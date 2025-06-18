Alter table t_inventory
ADD CONSTRAINT  uq_sku_code UNIQUE (sku_code);
