

# Some custom systemd default configurations we have to limit resource usage

do_install_append() {
	echo "Storage=volatile" >> ${D}/${sysconfdir}/systemd/journald.conf
	echo "RuntimeMaxUse=8M" >> ${D}/${sysconfdir}/systemd/journald.conf
	ln -s /dev/null ${D}/etc/systemd/system/rpcbind.service
	ln -s /dev/null ${D}/etc/systemd/system/ntpd.service
	ln -s /dev/null ${D}/etc/systemd/system/rngd.service
	ln -s /dev/null ${D}/etc/systemd/system/systemd-timesyncd.service
	# Removing default systemd network conf overriding gwc conf
	rm -f ${D}/lib/systemd/network/*
}

