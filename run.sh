chmod +x gradlew
./gradlew testPlugin
cd run || (echo 'unable to cd into run' && exit)
echo "eula=true" >> eula.txt
java -jar server.jar nogui
