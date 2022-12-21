package com.stockroute.designerservice.designer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "designer already exists")
public class DesignerAlreadyExitsException extends Exception{
}
