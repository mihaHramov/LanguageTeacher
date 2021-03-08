package com.aaa.bbb.ccc.languageteacher.data.repository.permissions

import com.tbruyelle.rxpermissions2.RxPermissions

class PermissionsRepository(val rxPermissions: RxPermissions) : IPermissionsRepository {
    override fun getPermissions(permissionsNames: String) = rxPermissions.request(permissionsNames)
}