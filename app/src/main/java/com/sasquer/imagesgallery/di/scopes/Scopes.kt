package com.sasquer.imagesgallery.di.scopes

import javax.inject.Scope

@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class PerApplication

@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class PerActivity

@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class PerFragment