package com.example.retrofit

import android.app.Application
import com.example.retrofit.api.QuoteService
import com.example.retrofit.api.RetrofitHelper
import com.example.retrofit.db.QuoteDatabase
import com.example.retrofit.repository.QuoteRepository

class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database, applicationContext)
    }
}