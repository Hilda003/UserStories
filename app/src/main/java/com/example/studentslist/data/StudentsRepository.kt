package com.example.studentslist.data

object StudentRepository {
    fun getStudents(): List<Student> {
        return listOf(
            Student("Alice Johnson", "New York, USA", "https://randomuser.me/api/portraits/women/1.jpg"),
            Student("Bob Smith", "London, UK", "https://randomuser.me/api/portraits/men/2.jpg"),
            Student("Charlie Brown", "Tokyo, Japan", "https://randomuser.me/api/portraits/men/3.jpg"),
            Student("David Lee", "Seoul, South Korea", "https://randomuser.me/api/portraits/men/4.jpg"),
            Student("Emma Watson", "Paris, France", "https://randomuser.me/api/portraits/women/5.jpg"),
            Student("Frank Miller", "Berlin, Germany", "https://randomuser.me/api/portraits/men/6.jpg"),
            Student("Grace Kelly", "Rome, Italy", "https://randomuser.me/api/portraits/women/7.jpg"),
            Student("Henry Cavill", "Madrid, Spain", "https://randomuser.me/api/portraits/men/8.jpg"),
            Student("Ivy Green", "Sydney, Australia", "https://randomuser.me/api/portraits/women/9.jpg"),
            Student("Jack Black", "Toronto, Canada", "https://randomuser.me/api/portraits/men/10.jpg")
        )
    }
}
