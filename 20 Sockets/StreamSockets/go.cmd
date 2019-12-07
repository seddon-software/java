REM --------------------------------------------------------
REM --
REM --	Fire off server and 3 clients
REM --
REM --------------------------------------------------------

pushd .
cd ..
start "Server" java -cp "." StreamSockets.Server
start "Client 1" java -cp "." StreamSockets.Client 1
start "Client 2" java -cp "." StreamSockets.Client 2
start "Client 3" java -cp "." StreamSockets.Client 3
popd

