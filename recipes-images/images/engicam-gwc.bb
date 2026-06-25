DESCRIPTION = "GWC image based on Engicam hardware"

LICENSE = "MIT"

inherit core-image

# TODO: REMOVE root/empty passwords once first rough testing is done
EXTRA_IMAGE_FEATURES = " ssh-server-openssh allow-empty-password allow-root-login empty-root-password "
EXTRA_IMAGE_FEATURES:remove = "tools-debug"

IMAGE_INSTALL:append = " \
	engicam-mtd-script \
	engicam-emmc-script \
	engicam-emmc-tools \
	iproute2 \
	canutils \
	mtd-utils \
	mtd-utils-ubifs \
	devmem2 \
	i2c-tools \
	imx-kobs \
	ethtool \
	dosfstools \
	e2fsprogs \
	curl \
	procps \
	xz \
	wget \
	tar \
	sysstat \
	lsof \
	iptables \
	gzip \
	grep \
	bzip2 \
	bash \
	dos2unix \
	nano \
	avahi-utils \
	usb-modeswitch \
	htop \
	bind-utils \
	iputils \
	coreutils \
	usbutils \
	iw \
	wpa-supplicant \
	json-c \
	ppp \
	hostapd \
	iproute2-ss \
	iproute2-devlink \
	iproute2-genl \
	iproute2-ifstat \
	iproute2-lnstat \
	iproute2-nstat \
	iproute2-rtacct \
	iproute2-tc \
	iproute2-tipc \
	libxml2-utils \
	libmodbus \
	libmicrohttpd \
	fswebcam \
	gd \
	chrony \
	chronyc \
	gpsd \
	libgps \
	openvpn \
	dhcpcd \
	gnupg \
	kernel-module-rtl8733bu \
	util-linux-agetty \
	util-linux-bits \
	util-linux-blkid \
	util-linux-blockdev \
	util-linux-cal \
	util-linux-cfdisk \
	util-linux-choom \
	util-linux-chrt \
	util-linux-col \
	util-linux-colrm \
	util-linux-coresched \
	util-linux-dmesg \
	util-linux-enosys \
	util-linux-exch \
	util-linux-fadvise \
	util-linux-fallocate \
	util-linux-fdisk \
	util-linux-findfs \
	util-linux-findmnt \
	util-linux-flock \
	util-linux-fsck \
	util-linux-getopt \
	util-linux-hardlink \
	util-linux-hexdump \
	util-linux-hwclock \
	util-linux-ionice \
	util-linux-ipcmk \
	util-linux-ipcrm \
	util-linux-ipcs \
	util-linux-kill \
	util-linux-ldattach \
	util-linux-logger \
	util-linux-look \
	util-linux-losetup \
	util-linux-lsblk \
	util-linux-lsclocks \
	util-linux-lscpu \
	util-linux-lsfd \
	util-linux-lsipc \
	util-linux-lsirq \
	util-linux-lslocks \
	util-linux-lsmem \
	util-linux-lsns \
	util-linux-mkfs \
	util-linux-more \
	util-linux-mount \
	util-linux-mountpoint \
	util-linux-namei \
	util-linux-nologin \
	util-linux-nsenter \
	util-linux-partx \
	util-linux-pipesz \
	util-linux-pivot-root \
	util-linux-prlimit \
	util-linux-readprofile \
	util-linux-rename \
	util-linux-renice \
	util-linux-resizepart \
	util-linux-rev \
	util-linux-rfkill \
	util-linux-rtcwake \
	util-linux-script \
	util-linux-scriptlive \
	util-linux-scriptreplay \
	util-linux-setpgid \
	util-linux-setpriv \
	util-linux-setsid \
	util-linux-setterm \
	util-linux-sfdisk \
	util-linux-sulogin \
	util-linux-switch-root \
	util-linux-taskset \
	util-linux-uclampset \
	util-linux-umount \
	util-linux-unshare \
	util-linux-uuidd \
	util-linux-uuidgen \
	util-linux-uuidparse \
	util-linux-waitpid \
	util-linux-wdctl \
	util-linux-whereis \
	kernel-devicetree \
"
# TO BE READDED possibly:
#	binutils //
#	minicom //
#	screen //
#	ppp-tools //
#	traceroute //
#	netcat //
#	gdbserver //
#	strace //
#	yasdi // Probably in core?
#	libnodave // Probably in core
#	sqlite3 // Probably in core?
#	opendnp3 // Dead and problems downloading :?
#	lua      // LUA and lighttpd probably built separately
#	luaposix
#	luacjson
#	luasys
#	luasocket
#	lighttpd
#	lighttpd-module-openssl
#	lighttpd-module-rewrite
#	lighttpd-module-redirect
#	lighttpd-module-alias
#	lighttpd-module-auth
#	lighttpd-module-authn-file
#	lighttpd-module-evasive
#	lighttpd-module-usertrack
#	lighttpd-module-setenv
#	lighttpd-module-cgi
#	lighttpd-module-compress
#	serialtools (do we need that??)
#	cantest (do we need that??)

# TOOLCHAIN_TARGET_TASK += " wpa-supplicant-staticdev libiec61850-staticdev lib60870-staticdev"

# This is necessary due to removal of some services in meta-engicam/recipes-core/systemd/systemd_%.bbappend
IMAGE_LOG_CHECK_EXCLUDES += "Failed to preset all unit: Unit .*[rpcbind.service|systemd-timesyncd.service] is masked"


