package com.jd.NameIdenifier

trait SecretAlphabet {
  protected val latinAlphabet = List('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
  protected val mvs: Char = 0x180E.toChar //MONGOLIAN_VOWEL_SEPARATOR
  protected val zws: Char = 0x200B.toChar //ZERO_WIDTH_SPACE
  protected val znj: Char = 0x200C.toChar //ZERO_WIDTH_NON_JOINER
  protected val zwj: Char = 0x200D.toChar //ZERO_WIDTH_JOINER
  protected val wrj: Char = 0x2060.toChar //WORD_JOINER
  protected val nbs: Char = 0xFEFF.toChar //ZERO_WIDTH_NO_BREAK_SPACE
  protected val privAlphabet: Array[Char] = Array(mvs,zws,znj,zwj,wrj,nbs)
}
