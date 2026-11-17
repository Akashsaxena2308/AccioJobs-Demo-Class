#!/bin/sh
set -eu

test -s /etc/secrets/aiven-ca.pem
rm -f /tmp/aiven-truststore.p12
keytool -importcert -noprompt \
  -alias aiven-ca \
  -file /etc/secrets/aiven-ca.pem \
  -keystore /tmp/aiven-truststore.p12 \
  -storetype PKCS12 \
  -storepass changeit

exec java -XX:MaxRAMPercentage=65.0 -jar /app/app.jar