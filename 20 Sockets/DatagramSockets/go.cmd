REM --------------------------------------------------------
REM --
REM --	Fire off sender and receiver
REM --
REM --------------------------------------------------------

pushd .
cd ..
start "Receiver" java -cp "." DatagramSockets.Receiver
start "Sender" java -cp "." DatagramSockets.Sender
popd

