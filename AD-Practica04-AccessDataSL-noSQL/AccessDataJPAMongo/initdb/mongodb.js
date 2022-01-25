conn = new Mongo();
// Nos vamos a la base de datos mongodb,
// si no lo haría por defecto en la BD definida en el mongodb.yml MONGO_INITDB_DATABASE
db = conn.getDB("mongodb");
// Borramos todas las colecciones
db.collection.drop();
db.commits.insert({});
db.departamentos.insert({});
db.issues.insert({});
db.jefes_proyecto.insert({});
db.login.insert({});
db.programadores.insert({});
db.proyectos.insert({});
db.repositorios.insert({});


//db = conn.getDB("blog");
//db.dropDatabase();

// db = conn.getDB("blog");

// Si queremos crear los datos a mano

// db.category.insert({ "_id": parseInt(1), "texto": "General"});
// db.category.insert({ "_id": parseInt(2), "texto": "Dudas"});
// db.category.insert({ "_id": parseInt(3), "texto": "Evaluación"});
// db.category.insert({ "_id": parseInt(4), "texto": "Pruebas" });

// // Secuencia de los numeros
// db.hibernate_sequences.insert({ "_id": "hibernate_sequence", "seq": 5 });