package com.example.viewmodels


import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.model.JokeResponse
import com.example.util.API
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {

    val joke = MutableLiveData<JokeResponse>()

    init {
        getRandomJoke()
    }

    @SuppressLint("CheckResult")
    private fun getRandomJoke() {
        API.apiService.getRandomJoke().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    joke.postValue(it)
                },
                {
//                    Toast.makeText(this , "Response Error" , Toast.LENGTH_LONG).show()
                }
            )
    }
}