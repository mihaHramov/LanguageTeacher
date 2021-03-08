package com.aaa.bbb.ccc.languageteacher.data.repository.permissions

import io.reactivex.Observable

interface IPermissionsRepository {
    fun getPermissions(permissionsNames: String): Observable<Boolean>
}