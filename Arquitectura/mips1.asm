.data
.text
addi $s0,$0,15
or $t0, $0, 0x3
or $t1, $0, 0x2
or $t2, $0, 0x1
l1:
beq $s0, $t2, l3
div $s0,$t1
mfhi $t3
beq $t3, $0 ,l2
mult $s0,$t0
mflo $s0
addi $s0, $s0 ,1
j l1
l2:
mflo $s0
j l1
l3:
