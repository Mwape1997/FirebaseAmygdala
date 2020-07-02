package com.ocd.amygdala.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.ocd.amygdala.data.UserData

object FirestoreUtil {
    val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }

    private val currentUserDocRef: DocumentReference
        get() = firestoreInstance.document(
            "users/${FirebaseAuth.getInstance().currentUser?.uid
                ?: throw NullPointerException("UID is null.")}"
        )

    fun updateUser(userData: UserData, onComplete: (String) -> Unit) {

        val task = currentUserDocRef.set(userData)

        task.continueWith {
            if (it.isSuccessful) {
                onComplete("success")
            }
        }.addOnFailureListener {
            onComplete("failure")
        }
    }
}