-- Dictionary Tables
INSERT INTO tipo_auto (id, tipo_auto) VALUES (1, 'Sedan') ON CONFLICT (id) DO NOTHING;
INSERT INTO tipo_auto (id, tipo_auto) VALUES (2, 'SUV') ON CONFLICT (id) DO NOTHING;

INSERT INTO estado_venta (id, estado_venta) VALUES (1, 'Disponible') ON CONFLICT (id) DO NOTHING;

INSERT INTO metodo_pago (id, metodo_pago) VALUES (1, 'Transferencia') ON CONFLICT (id) DO NOTHING;

INSERT INTO metodo_envio (id, metodo_envio) VALUES (1, 'Retiro') ON CONFLICT (id) DO NOTHING;

-- Dummy Venta for available cars
INSERT INTO venta (id, estado_id, metodo_pago_id, metodo_envio_id) VALUES (1, 1, 1, 1) ON CONFLICT (id) DO NOTHING;

-- Autos
INSERT INTO auto (id, modelo_auto, marca_auto, combustible_auto, origen_auto, color_auto, url_auto, precio_auto, velocidad_auto, rango_auto, descripcion_auto, tipo_auto_id, venta_id)
VALUES
(1, 'Model S', 'Tesla', 'Eléctrico', 'USA', 'Rojo', '/img/model_s.png', 94990, '322 km/h', '652 km', 'Sedán de lujo eléctrico', 1, 1),
(2, 'Model 3', 'Tesla', 'Eléctrico', 'USA', 'Blanco', '/img/model_3.png', 38990, '261 km/h', '568 km', 'Sedán compacto eléctrico', 1, 1),
(3, 'Model X', 'Tesla', 'Eléctrico', 'USA', 'Negro', '/img/model_x.webp', 109990, '262 km/h', '547 km', 'SUV eléctrico premium', 2, 1),
(4, 'Model Y', 'Tesla', 'Eléctrico', 'USA', 'Azul', '/img/model_s.png', 52990, '250 km/h', '533 km', 'SUV compacto eléctrico', 2, 1)
ON CONFLICT (id) DO NOTHING;

-- Update sequences to avoid collision with future inserts
SELECT setval('auto_id_seq', (SELECT MAX(id) FROM auto));
SELECT setval('tipo_auto_id_seq', (SELECT MAX(id) FROM tipo_auto));
SELECT setval('venta_id_seq', (SELECT MAX(id) FROM venta));
