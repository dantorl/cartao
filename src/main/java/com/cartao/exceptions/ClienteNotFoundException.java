package com.cartao.exceptions;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//jeito mais fácil de retornar exceções -> trow new ClienteNotFoundException();
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cliente não localizado")
public class ClienteNotFoundException extends RuntimeException {
}
