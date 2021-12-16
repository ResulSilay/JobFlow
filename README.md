# JobFlow

It is an example developed for using Coroutines flow. Job postings API is used.

## Usage

```kotlin
fun getAllJob() = flow {
    emit(ApiResult.Loading(true))
    val response = apiClient.client()?.create(JobService::class.java)?.getPostAll()
    response?.let {
        if (response.isSuccessful) {
            emit(
                ApiResult.Success(
                    _code = response.code(),
                    _data = response.body()
                )
            )
        } else {
            emit(
                ApiResult.Failure(
                    _code = response.code(),
                    _message = response.errorBody()?.toString()
                )
            )
        }
    }
    emit(ApiResult.Completed(_code = response?.code(), _message = response?.message()))
}
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
