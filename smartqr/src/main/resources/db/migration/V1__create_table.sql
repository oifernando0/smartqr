-- =========================
-- TB_ENTERPRISE
-- =========================
CREATE TABLE IF NOT EXISTS tb_enterprise (
    id SERIAL PRIMARY KEY,
    code VARCHAR(4) NOT NULL UNIQUE,
    name VARCHAR(20) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

-- =========================
-- TB_USER_ACCOUNT
-- =========================
CREATE TABLE IF NOT EXISTS tb_user_account (
    id UUID PRIMARY KEY,
    enterprise_id INTEGER NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(50) NOT NULL,
    role VARCHAR(20) NOT NULL DEFAULT 'COMUM',
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),

    CONSTRAINT ck_role CHECK(role in ('COMUM', 'ADMIN', 'SYSTEM')),

    CONSTRAINT fk_user_enterprise
        FOREIGN KEY (enterprise_id)
        REFERENCES tb_enterprise(id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

-- =========================
-- TB_PRODUCT
-- =========================
CREATE TABLE IF NOT EXISTS tb_product (
    id UUID PRIMARY KEY,
    enterprise_id INTEGER NOT NULL,
    name VARCHAR(20) NOT NULL,
    description TEXT NOT NULL,
    usage TEXT NOT NULL,
    how_to_use TEXT NOT NULL,
    image_url TEXT,
    status VARCHAR(8) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),

    CONSTRAINT ck_status CHECK(status in ('ACTIVE', 'INACTIVE')),

    CONSTRAINT fk_product_enterprise
        FOREIGN KEY (enterprise_id)
        REFERENCES tb_enterprise(id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

--Triggers

CREATE OR REPLACE FUNCTION set_updated_at_enterprise()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at := NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS trg_set_updated_at_enterprise ON tb_enterprise;

CREATE TRIGGER trg_set_updated_at_enterprise
BEFORE UPDATE ON tb_enterprise
FOR EACH ROW
EXECUTE FUNCTION set_updated_at_enterprise();


CREATE OR REPLACE FUNCTION set_updated_at_user_account()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at := NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS trg_set_updated_at_user_account ON tb_user_account;

CREATE TRIGGER trg_set_updated_at_user_account
BEFORE UPDATE ON tb_user_account
FOR EACH ROW
EXECUTE FUNCTION set_updated_at_user_account();


CREATE OR REPLACE FUNCTION set_updated_at_product()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at := NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS trg_set_updated_at_product ON tb_product;

CREATE TRIGGER trg_set_updated_at_product
BEFORE UPDATE ON tb_product
FOR EACH ROW
EXECUTE FUNCTION set_updated_at_product();
