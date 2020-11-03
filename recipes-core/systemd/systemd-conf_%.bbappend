# Removing default systemd network file that take precedence over gwc conf

do_install_append() {
  rm -f ${D}/lib/systemd/network/*
}
