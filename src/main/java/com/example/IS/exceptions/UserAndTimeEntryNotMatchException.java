package com.example.IS.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Time entry doesn't match to user")
public class UserAndTimeEntryNotMatchException extends Throwable {
}
