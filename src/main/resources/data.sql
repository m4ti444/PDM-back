-- Dictionary Tables
INSERT INTO tipo_auto (id, tipo_auto)
SELECT 1, 'Sedan'
WHERE NOT EXISTS (SELECT 1 FROM tipo_auto WHERE id = 1);
INSERT INTO tipo_auto (id, tipo_auto)
SELECT 2, 'SUV'
WHERE NOT EXISTS (SELECT 1 FROM tipo_auto WHERE id = 2);

INSERT INTO estado_venta (id, estado_venta)
SELECT 1, 'Disponible'
WHERE NOT EXISTS (SELECT 1 FROM estado_venta WHERE id = 1);

INSERT INTO metodo_pago (id, metodo_pago)
SELECT 1, 'Transferencia'
WHERE NOT EXISTS (SELECT 1 FROM metodo_pago WHERE id = 1);

INSERT INTO metodo_envio (id, metodo_envio)
SELECT 1, 'Retiro'
WHERE NOT EXISTS (SELECT 1 FROM metodo_envio WHERE id = 1);

-- Dummy Venta for available cars
INSERT INTO venta (id, estado_id, metodo_pago_id, metodo_envio_id)
SELECT 1, 1, 1, 1
WHERE NOT EXISTS (SELECT 1 FROM venta WHERE id = 1);

-- Default Region and Comuna
INSERT INTO region (id, nombreRegion)
SELECT 1, 'Region Metropolitana'
WHERE NOT EXISTS (SELECT 1 FROM region WHERE id = 1);
INSERT INTO comuna (id, nombreComuna, region_id)
SELECT 1, 'Santiago', 1
WHERE NOT EXISTS (SELECT 1 FROM comuna WHERE id = 1);

-- Roles
INSERT INTO roles (id, nombreRol)
SELECT 1, 'Admin'
WHERE NOT EXISTS (SELECT 1 FROM roles WHERE id = 1);
INSERT INTO roles (id, nombreRol)
SELECT 2, 'Vendedor'
WHERE NOT EXISTS (SELECT 1 FROM roles WHERE id = 2);
INSERT INTO roles (id, nombreRol)
SELECT 3, 'Cliente'
WHERE NOT EXISTS (SELECT 1 FROM roles WHERE id = 3);

-- Autos
INSERT INTO auto (id, modelo_auto, marca_auto, combustible_auto, origen_auto, color_auto, url_auto, precio_auto, velocidad_auto, rango_auto, descripcion_auto, tipo_auto_id, venta_id)
SELECT 1, 'Model S', 'Tesla', 'Eléctrico', 'USA', 'Rojo', '/img/model_s.png', 94990, '322 km/h', '652 km', 'Sedán de lujo eléctrico', 1, 1
WHERE NOT EXISTS (SELECT 1 FROM auto WHERE id = 1);
INSERT INTO auto (id, modelo_auto, marca_auto, combustible_auto, origen_auto, color_auto, url_auto, precio_auto, velocidad_auto, rango_auto, descripcion_auto, tipo_auto_id, venta_id)
SELECT 2, 'Model 3', 'Tesla', 'Eléctrico', 'USA', 'Blanco', '/img/model_3.png', 38990, '261 km/h', '568 km', 'Sedán compacto eléctrico', 1, 1
WHERE NOT EXISTS (SELECT 1 FROM auto WHERE id = 2);
INSERT INTO auto (id, modelo_auto, marca_auto, combustible_auto, origen_auto, color_auto, url_auto, precio_auto, velocidad_auto, rango_auto, descripcion_auto, tipo_auto_id, venta_id)
SELECT 3, 'Model X', 'Tesla', 'Eléctrico', 'USA', 'Negro', '/img/model_x.webp', 109990, '262 km/h', '547 km', 'SUV eléctrico premium', 2, 1
WHERE NOT EXISTS (SELECT 1 FROM auto WHERE id = 3);
INSERT INTO auto (id, modelo_auto, marca_auto, combustible_auto, origen_auto, color_auto, url_auto, precio_auto, velocidad_auto, rango_auto, descripcion_auto, tipo_auto_id, venta_id)
SELECT 4, 'Model Y', 'Tesla', 'Eléctrico', 'USA', 'Azul', '/img/model_s.png', 52990, '250 km/h', '533 km', 'SUV compacto eléctrico', 2, 1
WHERE NOT EXISTS (SELECT 1 FROM auto WHERE id = 4);

-- Update sequences to avoid collision with future inserts
SELECT setval('auto_id_seq', (SELECT MAX(id) FROM auto));
SELECT setval('tipo_auto_id_seq', (SELECT MAX(id) FROM tipo_auto));
SELECT setval('venta_id_seq', (SELECT MAX(id) FROM venta));
SELECT setval('region_id_seq', (SELECT MAX(id) FROM region));
SELECT setval('comuna_id_seq', (SELECT MAX(id) FROM comuna));
SELECT setval('roles_id_seq', (SELECT MAX(id) FROM roles));
