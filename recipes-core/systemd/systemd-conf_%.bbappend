# Removing default systemd network file that take precedence over gwc conf

do_install:append() {
  rm -f ${D}/lib/systemd/network/*
}
