# Provides the Ka-Ro TX6 common settings

require conf/machine/include/imx-base.inc
require conf/machine/include/tune-cortexa9.inc

SERIAL_CONSOLE = "115200 ttymxc0"

UBOOT_SUFFIX = "bin"
UBOOT_MAKE_TARGET = "u-boot.bin"
UBOOT_BINARY="u-boot.bin"

PREFERRED_PROVIDER_u-boot ?= "u-boot-karo"
PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-karo"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-karo"

MACHINE_FIRMWARE_append_mx6 = " linux-firmware-ath6k"
MACHINE_FEATURES += " pci wifi bluetooth"
IMAGE_FSTYPES_remove = "sdcard"
IMAGE_FSTYPES = "tar.bz2"

# Add NXP binary blob driver for the Vivante GPU to the kernel image.
# Otherwise settings in the Kernel defconfig are actively delete or ignored and
# the required external LKM ([RFS]/lib/modules/<kernel-version>/extra) is not
# available at all ( exception being if specific images are being "bitbaked"
# like: fsl-image-multimedia-full )

# Add Vivante GPU driver support
# Handle Vivante kernel driver setting:
#   0 - machine does not have Vivante GPU driver support
#   1 - machine has Vivante GPU driver support
MACHINE_HAS_VIVANTE_KERNEL_DRIVER_SUPPORT ?= "1"

# Use Vivante kernel driver module:
#   0 - enable the builtin kernel driver module
#   1 - enable the external kernel module
MACHINE_USES_VIVANTE_KERNEL_DRIVER_MODULE ?= "0"

TXBASE ?= "mb7"