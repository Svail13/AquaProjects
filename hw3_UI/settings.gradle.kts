rootProject.name = "hw3_UI"
include("src:test:org.example")
findProject(":src:test:org.example")?.name = "org.example"
