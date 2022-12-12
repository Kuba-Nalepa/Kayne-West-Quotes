package com.nalepa.kaynewestquotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nalepa.kaynewestquotes.network.ApiClient
import kotlinx.coroutines.launch


class MyViewModel: ViewModel() {
    private val _quote = MutableLiveData<String>()
    val quote: LiveData<String> = _quote

    init {
        setKayneQuote()
    }

    fun setKayneQuote() {
        viewModelScope.launch {
            _quote.value = ApiClient.retrofitService.fetchQuote().body()?.quote
        }
    }

}