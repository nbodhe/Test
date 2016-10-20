

freeStyleJob('newjob') {
    // name 'digital-item/prod1-engine'
    description("Do not change this config directly.")
    // jdk("JDK 1.7.0_67")
    label 'linux'
    logRotator(-1, 10000, 5, -1)
    scm {
        git {
            remote {
                url("https://github.com/mohitsethi/maven-sample-app.git")
            }
            branch '*/master'
        }
    }
    // antInstallation('Ant-1.9.0')
    triggers {
        githubPush()
        scm("* * * * *")
    }

    steps {
      shell("mvn clean install")
    }
}
