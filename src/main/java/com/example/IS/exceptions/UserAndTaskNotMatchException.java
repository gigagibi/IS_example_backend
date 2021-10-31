package com.example.IS.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User doesn't have this task")
public class UserAndTaskNotMatchException extends Throwable {
}
