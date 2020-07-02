package com.ocd.amygdala.data

data class UserData(var userID: String = "", var userImagePATH: String = "", var phoneNumber: String = "", var active: Boolean = false,
                    var firstName: String = "",
                    var lastName: String = "",
                    var email: String = "",
                    var fcmToken: String = "",
                    var selected: Boolean = false,
                    var userName: String = ""
)