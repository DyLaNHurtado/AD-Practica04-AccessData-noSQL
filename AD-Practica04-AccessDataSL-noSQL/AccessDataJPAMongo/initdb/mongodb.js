conn = new Mongo();
// Nos vamos a la base de datos mongodb,
// si no lo haría por defecto en la BD definida en el mongodb.yml MONGO_INITDB_DATABASE
db = conn.getDB("mongodb");
// Borramos todas las colecciones
db.collection.drop();

db.commits.insert({ 'titulo': 'Database ready!', 'texto': 'Se creo la base de datos','fecha':'2019-07-25 21:23:33.564','issue':'{}','repositorio':'{}','programador':'{}' });
db.commits.insert({ 'titulo': 'Commit 2!', 'texto2': 'Se creo la interfaz','fecha':'2019-07-25 21:23:33.564','issue':'{}','repositorio':'{}','programador':'{}' });

db.departamentos.insert({ "nombre": "Departamento Web", "jefe_departamento": {'nombre':'Cristiano Ronaldo','fecha_alta':'2019-07-25 21:23:33.564','salario':100,'tecnologias':['Java','TypeScript'],'departamento': '{}'}, "proy_finalizados": "{}","proy_desarrollo": "{}" ,"presupuesto": 200,"presupuesto_anual": 3000,"trabajadores":"{}"});
db.departamentos.insert({ "nombre": "Departamento Multiplataforma ", "jefe_departamento": {'nombre':'Peter Partker','fecha_alta':'2019-07-25 21:23:33.564','salario':300,'tecnologias':['Kotlin','Pascal'],'departamento': '{}'}, "proy_finalizados": "{}","proy_desarrollo": "{}" ,"presupuesto": 300,"presupuesto_anual": 9000,"trabajadores":"{}"});

db.issues.insert({ 'titulo': 'Issue 1', 'texto': 'textoooooo1', 'fecha': '2019-07-25 21:23:33.564','resuelta':true,'jefe_proyecto':'{}','programadores':'{}','repositorio':'{}','commit':'{}' });
db.issues.insert({ 'titulo': 'Issue 2', 'texto': 'textoooooo2', 'fecha': '2019-07-25 21:23:33.564','resuelta':false,'jefe_proyecto':'{}','programadores':'{}','repositorio':'{}','commit':'{}' });

db.jefes_proyecto.insert({ 'nombre':'Antony Flags','fecha_alta':'2019-07-25 21:23:33.564','salario':400,'tecnologias':['JavaScript','Lombok'] });
db.jefes_proyecto.insert({ 'nombre':'Eren Jaeger','fecha_alta':'2019-07-25 21:23:33.564','salario':500,'tecnologias':['Java','C#'] });

db.login.insert({ 'correo' : 'programador1@gmail.com', 'password':'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'fecha':'2019-07-25 21:23:33.564'});
db.login.insert({ 'correo' : 'programador2@gmail.com', 'password':'4aeb7ad6d5d37a041c4c5ce6562bf9e3caf05a42d931cef4d9e2a60ca623194d', 'fecha':'2019-07-25 21:23:33.564'});

db.programadores.insert({ 'nombre':'Emilio','fecha_alta':'2019-07-25 21:23:33.564','salario':200,'tecnologias':['Java','Python'],'departamento_id':'' });
db.programadores.insert({ 'nombre':'Dylan','fecha_alta':'2019-07-25 21:23:33.564','salario':201,'tecnologias':['Whitespace','.NET'],'departamento_id':'' });

db.proyectos.insert({ 'nombre' : 'Proyecto X', 'presupuesto' : 5000, 'fechaInicio' : '2019-07-25 21:23:33.564', 'fechaFin' : '2019-07-25 21:23:33.564', 'tecnologias' : ['Django','Vue'] , 'jefe' : {'nombre':'Antony Flags','fecha_alta':'','salario':400,'tecnologias':['JavaScript','Lombok']} ,'departamento_id':'', });
db.proyectos.insert({ 'nombre' : 'Proyecto Y', 'presupuesto' : 4000, 'fechaInicio' : '2019-07-25 21:23:33.564', 'fechaFin' : '', 'tecnologias' : ['PHP','Angular'] , 'jefe' : {'nombre':'Eren Jaeger','fecha_alta':'','salario':500,'tecnologias':['Java','C#']} ,'departamento_id':'', });

db.repositorios.insert({ 'nombre':'Repositorio 1', 'fecha_creacion' : '2019-07-25 21:23:33.564', 'proyecto_id': '', 'commits':[{'titulo': 'Database ready!', 'texto': 'Se creo la base de datos','fecha':'2019-07-25 21:23:33.564','issue':'{}','repositorio':'{}','programador':'{}' },{'titulo': 'Commit 2!', 'texto2': 'Se creo la interfaz','fecha':'','issue':'{}','repositorio':'{}','programador':'{}' }], 'issues':[{ 'titulo': 'Issue 1', 'texto': 'textoooooo1', 'fecha': '','resuelta':true,'jefe_proyecto':'{}','programadores':'{}','repositorio':'{}','commit':'{}' }] });
db.repositorios.insert({ 'nombre':'Repositorio 2', 'fecha_creacion' : '2019-07-25 21:23:33.564', 'proyecto_id': '', 'commits':[], 'issues':[{ 'titulo': 'Issue 2', 'texto': 'textoooooo2', 'fecha': '2019-07-25 21:23:33.564','resuelta':false,'jefe_proyecto':'{}','programadores':'{}','repositorio':'{}','commit':'{}' }] });




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