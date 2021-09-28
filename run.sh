CIDIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
java -version
ant -Dnb.internal.action.name=clean clean

ant -Dnb.internal.action.name=build jar

ant -Dnb.internal.action.name=test test

