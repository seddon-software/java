# --------------------------------------------------------
# --
# --	Fire off server and 3 clients
# --
# --------------------------------------------------------


cd ..
java -cp "." StreamSockets.Server &
java -cp "." StreamSockets.Client 1
java -cp "." StreamSockets.Client 2
java -cp "." StreamSockets.Client 3


