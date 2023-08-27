package com.tatayab.remote.FireBaseDataBase

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.tatayab.model.ResponseLogOnFireBase
import java.lang.Exception

class FirebaseDataBaseRealTimeManager {
    private lateinit var dbReference: DatabaseReference
    companion object{
        private val tableName = "APIRequests"
    }
    init {
         var database = Firebase.database
        dbReference = database?.getReference(tableName)!!
    }


    open fun logRequest(mResponseLogOnFireBase: ResponseLogOnFireBase) {
        try {
            dbReference?.setValue(mResponseLogOnFireBase)?.addOnSuccessListener {
                println("FIREBASE_DATA_SAVE LOGS SUCCESSFULLY")
            }
                ?.addOnFailureListener {
                    println("FIREBASE_DATA_SAVE LOGS Fail: " + it?.localizedMessage)
                }
        }catch (e:Exception){
            e.printStackTrace()
        }

    }

}