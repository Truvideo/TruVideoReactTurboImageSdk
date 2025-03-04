import TruvideoReactTurboImageSdk from './NativeTruvideoReactTurboImageSdk';

export function launchImageEdit(
  inputPath: string,
  outputPath: string
): Promise<string> {
  return TruvideoReactTurboImageSdk.launchImageEdit(inputPath, outputPath);
}

export function getFilePath(fileName: string): Promise<string> {
  return TruvideoReactTurboImageSdk.getFilePath(fileName);
}
