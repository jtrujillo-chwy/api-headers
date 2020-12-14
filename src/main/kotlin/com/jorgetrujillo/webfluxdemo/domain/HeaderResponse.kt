package com.jorgetrujillo.webfluxdemo.domain

import org.springframework.http.HttpMethod

data class HeaderResponse(
  val method: HttpMethod,
  val headers: Map<String, String>
)
