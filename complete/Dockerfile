FROM oracle/graalvm-ce:1.0.0-rc13 as graalvm
COPY . /home/app/complete
WORKDIR /home/app/complete
RUN ./build-native-image.sh

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/complete .
ENTRYPOINT ["./complete"]
