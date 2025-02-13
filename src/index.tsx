import TruvideoReactTurboImageSdk from './NativeTruvideoReactTurboImageSdk';

export function multiply(a: number, b: number): number {
  return TruvideoReactTurboImageSdk.multiply(a, b);
}
export function launchImageEdit(
  inputPath: string,
  outputPath: string
): Promise<string> {
  return TruvideoReactTurboImageSdk.launchImageEdit(inputPath, outputPath);
}

export function getFilePath(fileName: string): Promise<string> {
  return TruvideoReactTurboImageSdk.getFilePath(fileName);
}
