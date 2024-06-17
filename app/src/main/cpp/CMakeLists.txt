
cmake_minimum_required(VERSION 3.22.1)

project("shroomish_flag_checker")

add_library(${CMAKE_PROJECT_NAME} SHARED
        shroomish_flag_checker.cpp)

target_link_libraries(${CMAKE_PROJECT_NAME}
        android
        log)


add_library(whatsfun SHARED
        whatsfun.cpp)

target_link_libraries(whatsfun
        android
        log)