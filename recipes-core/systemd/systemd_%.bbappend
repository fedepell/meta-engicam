

# Remove recommend for systemd-mime as brings in mime db
RRECOMMENDS:${PN}:remove = "${PN}-mime"

# Remove some features we are not interested in
PACKAGECONFIG:remove = "timesyncd rfkill quotacheck localed hibernate backlight vconsole"

# Some custom systemd default configurations we have to limit resource usage
do_install:append() {
	# Remove some HWDB files to limit the size of that package, is stuff we will
	# never use on this hardware (OUI, acpi, PCI...)
	rm -f ${D}/usr/lib/udev/hwdb.d/{20-OUI.hwdb,20-acpi-vendor.hwdb,20-bluetooth-vendor-product.hwdb,20-pci*.hwdb,60-*.hwdb,70-*.hwdb,80-*.hwdb}

	echo "Storage=volatile" >> ${D}/${sysconfdir}/systemd/journald.conf
	echo "RuntimeMaxUse=8M" >> ${D}/${sysconfdir}/systemd/journald.conf

        # This is not very standard, but they are not there yet so bitbake will not
        # complain in QA. See in case rpcbind recipe bbappend for how to disable better
	ln -s /dev/null ${D}/etc/systemd/system/ntpd.service
	ln -s /dev/null ${D}/etc/systemd/system/rngd.service
	# Removing default systemd network conf overriding gwc conf
	rm -f ${D}/lib/systemd/network/*
}

