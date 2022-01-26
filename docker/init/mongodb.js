conn = new Mongo();
// Nos vamos a la base de datos mongodb,
// si no lo haría por defecto en la BD definida en el mongodb.yml MONGO_INITDB_DATABASE
db = conn.getDB("mongodb");
// Borramos todas las colecciones
//db.collection.drop();
db.ejemplo.insert({"fsafd":3123,"dfsgdf":123})
db.ejemplo.insert({"fsafd":222,"dfsgdf":22})