package app.flow.job.data.api.result

sealed class ApiResult<out T>(
    val status: ApiStatus,
    val code: Int?,
    val data: T?,
    val message: String?
) {

    data class Success<out R>(val _code: Int?, val _data: R?) : ApiResult<R>(
        status = ApiStatus.SUCCESS,
        code = _code,
        data = _data,
        message = null
    )

    data class Failure(val _code: Int?, val _message: String?) : ApiResult<Nothing>(
        status = ApiStatus.FAILURE,
        code = _code,
        data = null,
        message = _message
    )

    data class Loading(val isLoading: Boolean) : ApiResult<Nothing>(
        status = ApiStatus.LOADING,
        code = null,
        data = null,
        message = null
    )

    data class Completed(val _code: Int?, val _message: String?) : ApiResult<Nothing>(
        status = ApiStatus.COMPLETED,
        code = _code,
        data = null,
        message = _message
    )
}