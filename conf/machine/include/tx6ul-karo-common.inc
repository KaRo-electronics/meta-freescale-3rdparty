# Provides the Ka-Ro TX6UL common settings

require conf/machine/include/imx-base.inc
require conf/machine/include/tune-cortexa7.inc

SERIAL_CONSOLE = "115200 ttymxc0"

UBOOT_SUFFIX = "bin"
UBOOT_MAKE_TARGET = "u-boot.bin"
UBOOT_BINARY="u-boot.bin"
UBOOT_ENTRYPOINT_mx6ul = "0x80008000"

PREFERRED_PROVIDER_u-boot ?= "u-boot-karo"
PREFERRED_PROVIDER_virtual/kernel ?= "linux-karo"

IMAGE_FSTYPES = "tar.bz2"

TXBASE ?= "evalkit"