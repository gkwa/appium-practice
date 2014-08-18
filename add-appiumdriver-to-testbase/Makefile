archtypeid=meprotest
archetypeArtifactId=webdriver-java-quickstart-archetype

test: $(archtypeid)
	cd $< && mvn test

$(archtypeid): $(archetypeArtifactId)
	mvn archetype:generate -DarchetypeGroupId=ru.stqa.selenium -DarchetypeArtifactId=$(archetypeArtifactId) -DarchetypeVersion=0.7 -DgroupId=com.streambox.$@ -DartifactId=$@ -DinteractiveMode=false
	cd $(archtypeid) && gradle init --type pom

$(archetypeArtifactId):
	git clone git://github.com/barancev/$@.git
	cd $@ && mvn install

clean:
	rm -rf $(archtypeid)/target
