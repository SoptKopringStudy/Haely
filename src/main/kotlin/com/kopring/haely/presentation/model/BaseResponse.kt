package com.kopring.haely.model

import org.springframework.http.HttpStatus

enum class ResponseMessage(
    val status: HttpStatus,
    val message: String
){
    OK(HttpStatus.OK, "조회 성공"),
    CREATED(HttpStatus.CREATED, "등록 성공"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다");

    companion object{
        fun messageOf(status: HttpStatus) =
            values().find{it.status == status}?.message?: throw IllegalStateException("에러 내용 $status")
    }
}

data class BaseResponse<T>(
    val status: HttpStatus,
    val success: Boolean,
    val data: T
){
    sealed class Response{
        data class Success<T>(
            val statusCode : Int,
            val message : String,
            val data : T
        ): Response()

        data class Failure(
            val statusCode : Int,
            val message : String
        ): Response()
    }

    fun toSuccess() = Response.Success(
        status.value(),
        ResponseMessage.messageOf(status),
        data
    )

    fun toFailure() = Response.Failure(
        status.value(),
        ResponseMessage.messageOf(status)
    )
}
