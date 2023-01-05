
## Cifrado
Es el proceso de codificar la información original (texto plano) su objetivo es proteger 
datos sensibles. De manera que solo pueda ser descifrado utilizando una clave

Historia del cifrado:
1. Almacenar contraseñas en texto plano.(NO SEGURO ACTUALMENTE)
2. Almacenar contraseñas cifradas con función hash (NO SEGURO ACTUALMENTE)
3. Almacenar contraseñas cifradas con función hash + salt (NO SEGURO ACTUALMENTE)
4. Utilizar contraseñas cifradas con función adaptativa + factor de trabajo
(La seguridad se gana haciendo que la validación de la contraseña sea costosa computacionalmente.)

## Algoritmos en Spring Security
### Todos comparten la misma idea (punto 4 en la lista anterior).
* BCrypt (Se esta usando mas BCrypt)
* PBKDF2 (Este funciona mejor en GPU)
* scrypt
* argon2





