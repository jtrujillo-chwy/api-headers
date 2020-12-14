package com.jorgetrujillo.webfluxdemo.controllers

import com.jorgetrujillo.webfluxdemo.domain.RequestContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class HeaderInterceptor : HandlerInterceptor {

  @Autowired
  lateinit var requestContext: RequestContext

  companion object {
    val log: Logger = LoggerFactory.getLogger(this::class.java)
  }

  override fun preHandle(
    request: HttpServletRequest,
    response: HttpServletResponse,
    handler: Any
  ): Boolean {

    request.headerNames.asIterator().forEach { requestContext.headers[it] = request.getHeader(it) }
    log.info("Captured ${requestContext.headers.size} headers")

    return true
  }
}
