package com.betsanych.touroperator.specification;


public interface Specification<T> {

    boolean isSatisfiedBy(T t);

}
