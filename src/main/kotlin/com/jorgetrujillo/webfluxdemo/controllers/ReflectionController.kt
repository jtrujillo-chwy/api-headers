package com.jorgetrujillo.webfluxdemo.controllers

import com.jorgetrujillo.webfluxdemo.domain.HeaderResponse
import com.jorgetrujillo.webfluxdemo.domain.RequestContext
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/headers")
class ReflectionController(
  val requestContext: RequestContext
) {

  @GetMapping
  @ResponseBody
  fun getHeaders(): HeaderResponse {

    return HeaderResponse(HttpMethod.GET, requestContext.headers)
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  @ResponseBody
  fun createHeaders(): HeaderResponse {

    return HeaderResponse(HttpMethod.POST, requestContext.headers)
  }

  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  @ResponseBody
  fun putHeaders(): HeaderResponse {

    return HeaderResponse(HttpMethod.PUT, requestContext.headers)
  }

  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  @ResponseBody
  fun deleteHeaders(): HeaderResponse {
    return HeaderResponse(HttpMethod.DELETE, requestContext.headers)
  }
}
