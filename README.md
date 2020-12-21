# live_OpenFeign_FeignMock

Exemplo prático da utilização do OpenFeign e FeignMock para consumo de API

link : https://youtu.be/D5oepEJ9zcQ

# start project java -jar 

1 - Ir ao diretório target e executar o comando via terminal: java -jar feign-0.0.1-SNAPSHOT.jar
2 - Via Postman ou navegador chamar a url localhost:8080/posts

# start project container docker

1 - No diretório do projeto raiz executar o buld via terminal comando: docker build -t openfeign_feignmock .
2 - Após a montagem da imagem executar o comando via terminal: docker run -p 8000:8080 openfeign_feignmock
3 - Via Postman ou navegador chamar a url localhost:8000/posts




