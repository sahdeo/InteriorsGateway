package com.stockroute.designerservice.designer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "designer with the specified id not found")
public class DesignerNotFoundException extends Exception{
}
