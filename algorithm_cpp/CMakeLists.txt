cmake_minimum_required(VERSION 3.21)
project(algorithm_cpp)

set(CMAKE_CXX_STANDARD 11)

add_executable(heap_sort sort/heap_sort.cpp)
add_executable(list linked_list/list.cpp)
